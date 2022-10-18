package item7.ex4.asynchronous_callback;

interface OnGeekEventListener {
    public void onGeekEvent();
}

class B {
    private OnGeekEventListener mListener;

    public void registerOnGeekEventListener(OnGeekEventListener mListener){
        this.mListener = mListener;
    }

    public void doGeekStuff(){
        new Thread(new Runnable(){
            public void run(){
                System.out.println("Performing operation is Asynchronous task");

                if(mListener != null){
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        B obj = new B();
        OnGeekEventListener mListener  = new A();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
    }
}

public class A implements OnGeekEventListener{
    @Override
    public void onGeekEvent() {
        System.out.println("Performing callback after Asynchronous Task");
    }
}
