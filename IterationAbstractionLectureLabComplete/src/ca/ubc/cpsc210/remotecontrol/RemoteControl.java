package ca.ubc.cpsc210.remotecontrol;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * A remote control.
 */
public class RemoteControl implements Iterable<Channel>{
	
	// Add private variables to provide an implementation
	// of the remote here.
	private List<Channel> channels;
	
	/*
	 * Constructs remote control with no channels.
	 */
	public RemoteControl() {
		// Add initialization of private variables here.
		channels = new LinkedList<Channel>();
	}
	
	/*
	 * Adds a channel with the given channel number 
	 * to the remote control.  Maintains the order 
	 * in which channels were added.  Does not allow
	 * duplicate channels.
	 */
	public void addChannel(int numberOfChannel) {
		// Add a new channel to the remote here.
		Channel c = new Channel(numberOfChannel);
		if (!channels.contains(c))
			channels.add(c);		
	}

	/*
	 * Iterates over channels in the order in which
	 * they were added.  
	 */
	@Override
	public Iterator<Channel> iterator() {
		return channels.iterator();
	}
}

