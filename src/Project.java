import java.util.HashSet;
public class Project {

    String title;
    String description;
    String startDate;
    String endDate;
    int pId;
    HashSet<Worker> activeWorkers = new HashSet<>();

    Project(String title, String description, String startDate, String endDate, int pId)
    {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pId = pId;
    }

    public void removeIdFromProject(int id)
    {
        activeWorkers.remove(CEO.mapWorkerId.get(id));
    }

    public void removeAllWorker()
    {
        for(Worker w : activeWorkers)
        {
            w.removeProjectFromWorker(pId);
        }

        activeWorkers.clear();
    }

    public void assignWorker(Worker w)
    {
        activeWorkers.add(w);
    }
}
