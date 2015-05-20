package org.linphone.core;

public abstract interface PresenceService
{
  public abstract String getId();
  
  public abstract int setId(String paramString);
  
  public abstract PresenceBasicStatus getBasicStatus();
  
  public abstract int setBasicStatus(PresenceBasicStatus paramPresenceBasicStatus);
  
  public abstract String getContact();
  
  public abstract int setContact(String paramString);
  
  public abstract long getNbNotes();
  
  public abstract PresenceNote getNthNote(long paramLong);
  
  public abstract int addNote(PresenceNote paramPresenceNote);
  
  public abstract int clearNotes();
  
  public abstract long getNativePtr();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceService
 * JD-Core Version:    0.7.0.1
 */