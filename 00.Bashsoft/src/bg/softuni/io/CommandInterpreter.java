package bg.softuni.io;

import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;
import bg.softuni.staticData.SessionData;
import bg.softuni.staticData.ExceptionMessages;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    private Tester tester;
    private StudentsRepository studentsRepository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(
            Tester tester,
            StudentsRepository studentsRepository,
            DownloadManager downloadManager,
            IOManager ioManager) {
        this.tester = tester;
        this.studentsRepository = studentsRepository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String command = data[0].toLowerCase();

        try {
            parseCommand(input, data, command);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void parseCommand(String input, String[] data, String command) throws IOException {
        switch (command) {
            case "open":
                this.tryOpenFile(input, data);
                break;
            case "mkdir":
                this.tryCreateDirectory(input, data);
                break;
            case "ls":
                this.tryTraverseFolders(input, data);
                break;
            case "cmp":
                this.tryCompareFiles(input, data);
                break;
            case "cdrel":
                this.tryChangeRelativePath(input, data);
                break;
            case "cdabs":
                this.tryChangeAbsolutePath(input, data);
                break;
            case "readdb":
                this.tryReadDatabaseFromFile(input, data);
                break;
            case "help":
                this.tryGetHelp(input, data);
                break;
            case "show":
                this.tryShowWantedCourse(input, data);
                break;
            case "filter":
                this.tryPrintFilteredStudents(input, data);
                break;
            case "order":
                this.tryPrintOrderedStudents(input, data);
                break;
            case "download":
                this.tryDownloadFile(command, data);
                break;
            case "downloadasynch":
                this.tryDownloadFileOnNewThread(command, data);
                break;
            default:
                this.displayInvalidCommandMessage(input);
                break;
        }
    }

    private void tryDownloadFile(String command, String[] data) {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(command);
            return;
        }

        String fileUrl = data[1];
        this.downloadManager.download(fileUrl);
    }

    private void tryDownloadFileOnNewThread(String command, String[] data) {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(command);
            return;
        }

        String fileUrl = data[1];
        this.downloadManager.downloadOnNewThread(fileUrl);
    }

    private void tryPrintFilteredStudents(String input, String[] data) {
        if (data.length != 5) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String course = data[1];
        String filter = data[2].toLowerCase();
        String takeCommand = data[3].toLowerCase();
        String takeQuantity = data[4].toLowerCase();

        this.tryParseParametersForFilter(takeCommand, takeQuantity, course, filter);
    }

    private void tryParseParametersForFilter(
            String takeCommand, String takeQuantity,
            String courseName, String filter) {
        if (!takeCommand.equals("take")) {
            OutputWriter.displayException(ExceptionMessages.INVALID_TAKE_COMMAND);
            return;
        }

        if (takeQuantity.equals("all")) {
            this.studentsRepository.filterAndTake(courseName, filter);
            return;
        }

        try {
            int studentsToTake = Integer.parseInt(takeQuantity);
            this.studentsRepository.filterAndTake(courseName, filter, studentsToTake);
        } catch (NumberFormatException nfe) {
            OutputWriter.displayException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }

    private void tryPrintOrderedStudents(String input, String[] data) {
        if (data.length != 5) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String courseName = data[1];
        String orderType = data[2].toLowerCase();
        String takeCommand = data[3].toLowerCase();
        String takeQuantity = data[4].toLowerCase();

        this.tryParseParametersForOrder(takeCommand, takeQuantity, courseName, orderType);
    }

    private void tryParseParametersForOrder(
            String takeCommand, String takeQuantity,
            String courseName, String orderType) {
        if (!takeCommand.equals("take")) {
            OutputWriter.displayException(ExceptionMessages.INVALID_TAKE_COMMAND);
            return;
        }

        if (takeQuantity.equals("all")) {
            this.studentsRepository.orderAndTake(courseName, orderType);
            return;
        }

        try {
            int studentsToTake = Integer.parseInt(takeQuantity);
            this.studentsRepository.orderAndTake(courseName, orderType, studentsToTake);
        } catch (NumberFormatException nfe) {
            OutputWriter.displayException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }

    private void tryShowWantedCourse(String input, String[] data) {
        if (data.length != 2 && data.length != 3) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.studentsRepository.getStudentsByCourse(courseName);
        }

        if (data.length == 3) {
            String courseName = data[1];
            String userName = data[2];
            this.studentsRepository.getStudentMarksInCourse(courseName, userName);
        }
    }

    private void tryOpenFile(String input, String[] data) throws IOException {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "/" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }

    private void tryCompareFiles(String input, String[] data) throws IOException {
        if (data.length != 3) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];
        this.tester.compareContent(firstPath, secondPath);
    }

    private void tryGetHelp(String input, String[] data) {
        if (data.length != 1) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        displayHelp();
    }

    private void tryReadDatabaseFromFile(String input, String[] data) throws IOException {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        this.studentsRepository.loadData(fileName);
    }

    private void tryChangeAbsolutePath(String input, String[] data) {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String absolutePath = data[1];
        this.ioManager.changeCurrentDirAbsolute(absolutePath);
    }

    private void tryChangeRelativePath(String input, String[] data) {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String relativePath = data[1];
        this.ioManager.changeCurrentDirRelativePath(relativePath);
    }

    private void tryTraverseFolders(String input, String[] data) {
        if (data.length != 1 && data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 1) {
            this.ioManager.traverseDirectory(0);
        }

        if (data.length == 2) {
            this.ioManager.traverseDirectory(Integer.valueOf(data[1]));
        }
    }

    private void tryCreateDirectory(String input, String[] data) {
        if (data.length != 2) {
            this.displayInvalidCommandMessage(input);
            return;
        }

        String folderName = data[1];
        this.ioManager.createDirectoryInCurrentFolder(folderName);
    }

    private void displayInvalidCommandMessage(String input) {
        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.displayException(output);
    }

    private void displayHelp() {
        StringBuilder helpBuilder = new StringBuilder();
        helpBuilder.append("make directory - mkdir nameOfFolder")
                .append(System.lineSeparator());
        helpBuilder.append("traverse directory - ls depth")
                .append(System.lineSeparator());
        helpBuilder.append("comparing files - cmp absolutePath1 absolutePath2")
                .append(System.lineSeparator());
        helpBuilder.append("change directory - cdRel relativePath or \"..\" for level up")
                .append(System.lineSeparator());
        helpBuilder.append("change directory - cdAbs absolutePath")
                .append(System.lineSeparator());
        helpBuilder.append("read students data base - readDb fileName")
                .append(System.lineSeparator());
        helpBuilder.append("filter students - filter {courseName} excellent/average/poor take 2/5/all")
                .append(System.lineSeparator());
        helpBuilder.append("order students - order {courseName} ascending/descending take 20/10/all")
                .append(System.lineSeparator());
        helpBuilder.append("download file - download URL (saved in current directory)")
                .append(System.lineSeparator());
        helpBuilder.append("download file on new thread - downloadAsynch URL (saved in the current directory)")
                .append(System.lineSeparator());
        helpBuilder.append("get help – help")
                .append(System.lineSeparator());

        OutputWriter.writeMessage(helpBuilder.toString());
        OutputWriter.writeEmptyLine();
    }
}
