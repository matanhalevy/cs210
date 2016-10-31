package ca.ubc.cpsc210.taskmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Project extends WorkUnit{
    private List<WorkUnit> units;

    public Project(List<WorkUnit> subprojects, List<WorkUnit> tasks) {
        this.units = new ArrayList<WorkUnit>();
    }

    public void addUnit(WorkUnit wu){
        units.add(wu);
    }

    @Override
    public int hoursToComplete() {
        int total = 0;
        for (int i = 0; i < units.size(); i++) {
            total = total + units.get(i).hoursToComplete();
        }
        return total;
    }
}
