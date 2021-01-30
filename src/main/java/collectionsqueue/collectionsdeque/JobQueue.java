package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;
import java.util.*;

public class JobQueue {

    public Job dispatchUrgentJob(Deque<Job> jobs){
        if (jobs.isEmpty()){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs){
        if (jobs.isEmpty()){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollLast();
    }

    public Deque<Job> addJobByUrgency(Job... jobs){
        Deque<Job> jj = new ArrayDeque<>();
        for (Job j : jobs){
            if (j.isUrgent()){
                jj.addFirst(j);
            } else {
                jj.addLast(j);
            }
        }
        return jj;
    }

}
