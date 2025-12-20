package interview.asked;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DeleteFilesByType {

    // Method to delete files by extension in the given directory
    public static void deleteFilesByType(Path startDir, String fileExtension) throws IOException {
        try (Stream<Path> paths = Files.walk(startDir)) {
            paths
                    .filter(Files::isRegularFile) // Only regular files (not directories)
                    .filter(path -> path.toString().endsWith(fileExtension)) // Filter by file extension
                    .forEach(path -> {
                        try {
                            Files.delete(path); // Delete the file
                            System.out.println("Deleted: " + path);
                        } catch (IOException e) {
                            System.err.println("Failed to delete: " + path + " " + e.getMessage());
                        }
                    });
        }
    }

    public static void main(String[] args) {
        // Specify the directory and file extension you want to delete
        String directoryPath = "/Users/manishkumar/manish/BKP_202410/Photos/Google_Photos";
        Path directory = Paths.get(directoryPath);
        String fileExtension = ".json"; // Specify the file extension to delete

        try {
            deleteFilesByType(directory, fileExtension);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
