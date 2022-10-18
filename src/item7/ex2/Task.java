package item7.ex2;

import groovy.util.logging.Slf4j;

import java.util.logging.Logger;


public abstract class Task {

    final void executeWith(Callback callback){
        execute();

    }
    public abstract void execute();
}

@Slf4j
final class SimpleTask extends Task{

    @Override
    public void execute(){
        Logger.getGlobal().info("Perform some important activity and after call the callback method.");
    }
}

class TaskMain {
    public static void main(String[] args) {
        var task = new SimpleTask();
        task.executeWith(() -> Logger.getGlobal().info("I'm done now."));
    }
}
