
import java.util.concurrent.locks.*;

class TicketBookingSystem {
    private final boolean[] seats;
    private final Lock lock;

    public TicketBookingSystem(int totalSeats) {
        seats = new boolean[totalSeats];
        lock = new ReentrantLock();
    }

    public boolean bookSeat(int seatNumber, String customerType) {
        lock.lock();
        try {
            if (seatNumber < 0 || seatNumber >= seats.length || seats[seatNumber]) {
                System.out.println("Error: Seat " + seatNumber + " already booked.");
                return false;
            }
            seats[seatNumber] = true;
            System.out.println(customerType + " Booking: Seat " + seatNumber + " confirmed.");
            return true;
        } finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final int seatNumber;
    private final String customerType;

    public Customer(TicketBookingSystem bookingSystem, int seatNumber, String customerType, int priority) {
        this.bookingSystem = bookingSystem;
        this.seatNumber = seatNumber;
        this.customerType = customerType;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(seatNumber, customerType);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);

        Customer vip1 = new Customer(system, 1, "VIP", Thread.MAX_PRIORITY);
        Customer reg1 = new Customer(system, 2, "Regular", Thread.NORM_PRIORITY);
        Customer reg2 = new Customer(system, 1, "Regular", Thread.NORM_PRIORITY);

        vip1.start();
        reg1.start();
        reg2.start();
    }
}

