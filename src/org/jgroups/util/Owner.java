package org.jgroups.util;


import org.jgroups.Address;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;



/**
 * Represents an 'owner', which is an address and thread ID
 * @author Bela Ban
 */
public class Owner implements Streamable {
    protected Address address;
    protected long    thread_id;

    public Owner() {
    }

    public Owner(Address address, long thread_id) {
        this.address=address;
        this.thread_id=thread_id;
    }

    public Address getAddress() {
        return address;
    }

    public long getThreadId() {
        return thread_id;
    }

    public void writeTo(DataOutput out) throws IOException {
        Util.writeAddress(address, out);
        Util.writeLong(thread_id, out);
    }

    public void readFrom(DataInput in) throws IOException, IllegalAccessException, InstantiationException {
        address=Util.readAddress(in);
        thread_id=Util.readLong(in);
    }

    public boolean equals(Object obj) {
        Owner other=(Owner)obj;
        return address.equals(other.address) && thread_id == other.thread_id;
    }

    public int hashCode() {
        return (int)(address.hashCode() + thread_id);
    }

    public String toString() {
        return address + "::" + thread_id;
    }
}