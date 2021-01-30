package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs){
        Queue<Job> prioritizedJobs = new PriorityQueue<>();
        for (Job j : jobs){
            prioritizedJobs.add(j);
        }
        return prioritizedJobs;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()){
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.remove();
    }

}
