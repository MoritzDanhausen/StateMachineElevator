package state_machine_elevator;

public class Elevator {

	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor){
		this.dest_Floor=dest_floor;
		System.out.println("*** Destination floor is: "+ dest_Floor);
		arrive_atFloor();
	}

	private void arrive_atFloor() {
		State.Current_State = State.Idle;
		if (current_Floor < dest_Floor) {
			go_up();
		}else if (current_Floor > dest_Floor) {
			go_down();		
		}else {
			System.out.println("--------------------------------------------");
			System.out.println("Your state is: "+State.Current_State);
			System.out.println("You are currently at floor: "+current_Floor);
			System.out.println("You have arrived at your destination.");
		}
	}

	private void go_down() {
		// TODO Auto-generated method stub
		State.Current_State = State.Moving_down;
		current_Floor = current_Floor - 1;
		System.out.println("--------------------------------------------");
		System.out.println("Your state is: "+State.Current_State);
		System.out.println("You are currently at floor: "+current_Floor);
		if (current_Floor > dest_Floor) {
			go_down();
		}else {
			arrive_atFloor();
		}		
	}

	private void go_up() {
		// TODO Auto-generated method stub
		State.Current_State = State.Moving_up;
		current_Floor = current_Floor + 1;
		System.out.println("--------------------------------------------");
		System.out.println("Your state is: "+State.Current_State);
		System.out.println("You are currently at floor: "+current_Floor);
		if (current_Floor < dest_Floor) {
			go_up();
		}else {
			arrive_atFloor();
		}
		
	}
}
