import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

public class CEO {

    public static HashMap<Integer, Worker> mapWorkerId = new HashMap<>();
    public static HashMap<Integer, Project> mapProjectId = new HashMap<>();

    
    public void addWorker(String name, int id, String dept, String designation)
    {
        Worker w = new Worker(name, id, dept, designation);

        mapWorkerId.put(id,w);

    }

    public void removeWorker(int wId)
    {
        Worker w = mapWorkerId.get(wId);

        w.removeAllProject();

        mapWorkerId.remove(wId);
    }

    public void addProject(String title, String description, String startDate, String endDate, int pId)
    {
        Project p = new Project(title, description, startDate, endDate, pId);

        mapProjectId.put(pId, p);
    }

    public void removeProject(int pId)
    {
        Project p = mapProjectId.get(pId);

        p.removeAllWorker();

        mapProjectId.remove(pId);
    }

    public void addWorkerToProject(int wId, int pId)
    {
        Worker w = mapWorkerId.get(wId);
        Project p = mapProjectId.get(pId);

        w.assignProject(p);
        p.assignWorker(w);
    }

    public void removeWorkerFromProject(int wId, int pId)
    {
        Worker w = mapWorkerId.get(wId);
        Project p = mapProjectId.get(pId);

        w.removeProjectFromWorker(pId);
        p.removeIdFromProject(wId);
    }

    public void changeDept(int wId)
    {
        Worker w = mapWorkerId.get(wId);

        if(w.dept.equals("Engineering"))
        {
            w.dept = "Management";
        }
        else
        {
            w.dept = "Engineering";
        }

        w.removeAllProject();
    }

    public static void main(String[] args)
    {

    }
}
