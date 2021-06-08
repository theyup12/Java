package hw;
public class runClock {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
    static class Display{
        private int value = 0;
        private int limit = 0;
        public Display(int limit){
            this.limit = limit;
        }
        public void setValue(int val){
            this.value = val;
        }
        public int getValue(){
            return value;
        } 
        public void increase(){
            value++;
            if(value == limit){
                value = 0;
            }
        }
    }
    static class Clock{
        private Display hours = new Display(24);
        private Display min = new Display(60);
        private Display sec = new Display(60);
        public Clock(int hr, int mins, int seconds){
            hours.setValue(hr);
            min.setValue(mins);
            sec.setValue(seconds);
        }
        public void tick(){            
            sec.increase();
            if(sec.getValue() == 0){
                min.increase();
                if(min.getValue() == 0){
                    hours.increase();
                }
            }
            
        }
        public String toString(){
            String str = String.format("%02d:%02d:%02d", hours.getValue(), min.getValue(), sec.getValue());
            return str;
        }

    }
}
