package bg.softuni;

import bg.softuni.io.CommandInterpreter;
import bg.softuni.io.IOManager;
import bg.softuni.io.InputReader;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.RepositoryFilter;
import bg.softuni.repository.RepositorySorter;
import bg.softuni.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {

        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();

        RepositoryFilter repositoryFilter = new RepositoryFilter();
        RepositorySorter repositorySorter = new RepositorySorter();
        StudentsRepository studentsRepository = new StudentsRepository(repositoryFilter, repositorySorter);

        CommandInterpreter commandInterpreter = new CommandInterpreter(
                tester, studentsRepository, downloadManager, ioManager
        );

        InputReader reader = new InputReader(commandInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
