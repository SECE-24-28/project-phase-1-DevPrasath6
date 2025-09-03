public class Task {
    private String title;
    private String description;
    private String status;

    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    public void markCompleted() {
        this.status = "Completed";
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Description: " + description + " | Status: " + status;
    }

    public String toFileString() {
        return title + "," + description + "," + status;
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split(",", 3);
        if (parts.length == 3) {
            return new Task(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}
