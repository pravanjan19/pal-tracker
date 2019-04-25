package io.pivotal.pal.tracker;

import java.util.HashMap;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long, TimeEntry> entries = new HashMap<>();

    long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        entries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        return entries.get(id);

    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
            if(find(id)==null) return null;
        TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        entries.replace(id,updatedEntry);
        return updatedEntry;

    }

@Override
  public void delete(Long id){
    entries.remove(id);
  }


}
