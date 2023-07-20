import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Worker {

    String name;
    int id;
    String dept;
    String designation;
    boolean isPresent = false;
    HashSet<Project> activeProject = new HashSet<>();

    Worker(String name, int id, String dept, String designation)
    {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this .designation = designation;
    }

    public void markAttendance()
    {
        isPresent = true;
    }

    public void assignProject(Project newProject)
    {
        activeProject.add(newProject);
    }

    public void removeAllProject() {

        for(Project p: activeProject)
        {
            p.removeIdFromProject(id);
        }

        activeProject.clear();
    }

    public void removeProjectFromWorker(int pId) {

        activeProject.remove(CEO.mapProjectId.get(pId));
    }
}
