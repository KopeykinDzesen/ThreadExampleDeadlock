public class Main {

    public static void main(String[] args) {

        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.resourceA = resourceA;
        threadB.resourceB = resourceB;
        threadA.start();
        threadB.start();

    }

}

class ThreadA extends Thread{
    ResourceA resourceA;

    public void run() {
        System.out.println(resourceA.getI());
    }
}

class ThreadB extends Thread{
    ResourceB resourceB;

    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA{
    ResourceB resourceB;

    public synchronized int getI(){
        return resourceB.returnI();
    }
    public synchronized int returnI(){
        return 1;
    }
}

class ResourceB{
    ResourceA resourceA;

    public synchronized int getI(){
        return resourceA.returnI();
    }
    public synchronized int returnI(){
        Thread.yield();
        return 2;
    }
}
