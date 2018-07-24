public class windshieldWiper {
	public static void main(String[] args){
	private lever l;
	private dial d;
	private wiper w;
	
	public windshieldWiper(int wiperSpeed, String leverPosition, int dialPosition) {
		l = new lever(leverPosition);
		d = new dial(dialPosition);
		w = new wiper(wiperSpeed);
		}
	
	// Get the current wiper speed.
	public int getWiperSpeed() {
	return w.getWiperSpeed();
	}
	// Set the wiper speed.
	public void setWiperSpeed(int wiperSpeed) {
	w.setWiperSpeed(wiperSpeed);
	}
	// Get the current position of the lever.
	public String getLeverPosition() {
	return l.getLeverPosition();
	}
	// Set the lever position.
	public void setLeverPosition(String leverPosition) {
	l.setLeverPosition(leverPosition);
	if (l.getLeverPosition()=="OFF")
	{
		w.setWiperSpeed(0);
	}
	else if(l.getLeverPosition()=="LOW")
	{
		w.setWiperSpeed(30);
	}
	else if (l.getLeverPosition()=="HIGH")
	{
		w.setWiperSpeed(60);
	}
	else if (l.getLeverPosition()=="INT")
	{
		if (d.getDialPosition()==1)
		{
			w.setWiperSpeed(4);
		}
		else if(d.getDialPosition()==2)
		{
			w.setWiperSpeed(6);
		}
		else if(d.getDialPosition()==3)
		{
			w.setWiperSpeed(12);
		}
	}
	}
	// Get the current position of the dial.
	public int getDialPosition() {
	return d.getDialPosition();
	}
	// Set the dial position.
	public void setDialPosition(int dialPosition) {
	d.setDialPosition(dialPosition);
	}
	// Move the lever up and set new wiper speed.
	public void senseLeverUp() throws LeverErrorException {
	if((l.getLeverPosition()).equals("OFF")) {
	l.setLeverPosition("INT");
	switch(d.getDialPosition()) {
	case 1: {
	w.setWiperSpeed(4);
	break;
	}
	case 2: {
	w.setWiperSpeed(6);
	break;
	}
	case 3: {
	w.setWiperSpeed(12);
	break;
	}
	}
	}
	else if((l.getLeverPosition()).equals("INT")) {
		l.setLeverPosition("LOW");
		w.setWiperSpeed(30);
	}
	else if((l.getLeverPosition()).equals("LOW")) {
		l.setLeverPosition("HIGH");
		w.setWiperSpeed(60);
	}
	else if((l.getLeverPosition()).equals("HIGH")) {
	System.out.println("ERROR: leverPosition already at HIGH.");
	throw new LeverErrorException();
	}
	}
	// Move the lever down and set new wiper speed.

	public void senseLeverDown() throws LeverErrorException {
	if((l.getLeverPosition()).equals("OFF")) {
	System.out.println("ERROR: leverPosition already at OFF.");
	throw new LeverErrorException();
	}
	else if((l.getLeverPosition()).equals("INT")) {
		l.setLeverPosition("OFF");
	w.setWiperSpeed(0);
	}
	else if((l.getLeverPosition()).equals("LOW")) {
		l.setLeverPosition("INT");
	switch(d.getDialPosition()) {
	case 1: {
		w.setWiperSpeed(4);
	break;
	}
	case 2: {
		w.setWiperSpeed(6);
	break;
	}
	case 3: {
		w.setWiperSpeed(12);
	break;
	}
	}
	}
	else if((l.getLeverPosition()).equals("HIGH")) {
		l.setLeverPosition("LOW");
	w.setWiperSpeed(30);
	}
	}
	
	
	// Move the dial up and set the wiper speed.
	public void senseDialUp() throws DialErrorException {
	if(d.getDialPosition() == 3) {
	System.out.println("Already on highest setting");
	throw new DialErrorException();
	}
	else {
		d.setDialPosition(d.getDialPosition()+1);
	if((l.getLeverPosition()).equals("INT")) {
	switch(d.getDialPosition()) {
	case 1: {
		w.setWiperSpeed(4);
	break;
	}

	case 2: {
		w.setWiperSpeed(6);
	break;
	}
	case 3: {
		w.setWiperSpeed(12);
	break;
	}
	}
	}
	else {
	// No Action
	}
	}
	}
	// Move the dial down and set the wiper speed.
	public void senseDialDown() throws DialErrorException {
	if(d.getDialPosition() == 1) {
	System.out.println("Already on lowest setting");
	throw new DialErrorException();
	}
	else {
		d.setDialPosition(d.getDialPosition()-1);
	if((l.getLeverPosition()).equals("INT")) {
	switch(d.getDialPosition()) {
	case 1: {
		w.setWiperSpeed(4);
	break;
	}
	case 2: {
		w.setWiperSpeed(6);
	break;
	}
	case 3: {
		w.setWiperSpeed(12);
	break;
	}
	}
	}
	else {
	// No action.
	}
	}
	}
	}
}
