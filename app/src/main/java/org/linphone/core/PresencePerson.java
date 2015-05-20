package org.linphone.core;

public abstract interface PresencePerson
{
  public abstract String getId();
  
  public abstract int setId(String paramString);
  
  public abstract long getNbActivities();
  
  public abstract PresenceActivity getNthActivity(long paramLong);
  
  public abstract int addActivity(PresenceActivity paramPresenceActivity);
  
  public abstract int clearActivities();
  
  public abstract long getNbNotes();
  
  public abstract PresenceNote getNthNote(long paramLong);
  
  public abstract int addNote(PresenceNote paramPresenceNote);
  
  public abstract int clearNotes();
  
  public abstract long getNbActivitiesNotes();
  
  public abstract PresenceNote getNthActivitiesNote(long paramLong);
  
  public abstract int addActivitiesNote(PresenceNote paramPresenceNote);
  
  public abstract int clearActivitesNotes();
  
  public abstract long getNativePtr();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresencePerson
 * JD-Core Version:    0.7.0.1
 */