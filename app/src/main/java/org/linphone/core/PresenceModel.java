package org.linphone.core;

public abstract interface PresenceModel
{
  public abstract PresenceBasicStatus getBasicStatus();
  
  public abstract int setBasicStatus(PresenceBasicStatus paramPresenceBasicStatus);
  
  public abstract long getTimestamp();
  
  public abstract String getContact();
  
  public abstract void setContact(String paramString);
  
  public abstract PresenceActivity getActivity();
  
  public abstract int setActivity(PresenceActivityType paramPresenceActivityType, String paramString);
  
  public abstract long getNbActivities();
  
  public abstract PresenceActivity getNthActivity(long paramLong);
  
  public abstract int addActivity(PresenceActivity paramPresenceActivity);
  
  public abstract int clearActivities();
  
  public abstract PresenceNote getNote(String paramString);
  
  public abstract int addNote(String paramString1, String paramString2);
  
  public abstract int clearNotes();
  
  public abstract long getNbServices();
  
  public abstract PresenceService getNthService(long paramLong);
  
  public abstract int addService(PresenceService paramPresenceService);
  
  public abstract int clearServices();
  
  public abstract long getNbPersons();
  
  public abstract PresencePerson getNthPerson(long paramLong);
  
  public abstract int addPerson(PresencePerson paramPresencePerson);
  
  public abstract int clearPersons();
}


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceModel
 * JD-Core Version:    0.7.0.1
 */