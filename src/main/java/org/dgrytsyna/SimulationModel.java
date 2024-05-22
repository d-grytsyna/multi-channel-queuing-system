package org.dgrytsyna;

import java.util.concurrent.*;

public class SimulationModel implements Callable<FinalModelStatistic> {

    @Override
    public FinalModelStatistic call() throws Exception {
        return  launchModel();
    }

    public FinalModelStatistic launchModel(){
        ExecutorService executorService =  Executors.newCachedThreadPool();
        HandlerQueue handlerQueue = new HandlerQueue();
        int handlersAmount = 4;
        for(int i=0; i<handlersAmount; i++){
            executorService.execute(new Handler(handlerQueue));
        }
        executorService.execute(new RequestProducer(handlerQueue));
        Future<FinalModelStatistic> finalModelStatistic = executorService.submit(new StatisticCollector(handlerQueue));
        FinalModelStatistic result = new FinalModelStatistic();
        try {
            result = finalModelStatistic.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return result;
    }
}
