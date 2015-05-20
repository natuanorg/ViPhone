/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */
/*  8:   */ public class OnlineStatus
/*  9:   */ {
/* 10:31 */   private static Vector<OnlineStatus> values = new Vector();
/* 11:35 */   public static OnlineStatus Offline = new OnlineStatus(0, "Offline");
/* 12:39 */   public static OnlineStatus Online = new OnlineStatus(1, "Online");
/* 13:43 */   public static OnlineStatus Busy = new OnlineStatus(2, "Busy");
/* 14:47 */   public static OnlineStatus BeRightBack = new OnlineStatus(3, "BeRightBack");
/* 15:51 */   public static OnlineStatus Away = new OnlineStatus(4, "Away");
/* 16:55 */   public static OnlineStatus OnThePhone = new OnlineStatus(5, "OnThePhone");
/* 17:59 */   public static OnlineStatus OutToLunch = new OnlineStatus(6, "OutToLunch ");
/* 18:63 */   public static OnlineStatus DoNotDisturb = new OnlineStatus(7, "DoNotDisturb");
/* 19:67 */   public static OnlineStatus StatusMoved = new OnlineStatus(8, "StatusMoved");
/* 20:71 */   public static OnlineStatus StatusAltService = new OnlineStatus(9, "StatusAltService");
/* 21:75 */   public static OnlineStatus Pending = new OnlineStatus(10, "Pending");
/* 22:   */   protected final int mValue;
/* 23:   */   private final String mStringValue;
/* 24:   */   
/* 25:   */   private OnlineStatus(int value, String stringValue)
/* 26:   */   {
/* 27:82 */     this.mValue = value;
/* 28:83 */     values.addElement(this);
/* 29:84 */     this.mStringValue = stringValue;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public static OnlineStatus fromInt(int value)
/* 33:   */   {
/* 34:87 */     for (int i = 0; i < values.size(); i++)
/* 35:   */     {
/* 36:88 */       OnlineStatus state = (OnlineStatus)values.elementAt(i);
/* 37:89 */       if (state.mValue == value) {
/* 38:89 */         return state;
/* 39:   */       }
/* 40:   */     }
/* 41:91 */     throw new RuntimeException("state not found [" + value + "]");
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String toString()
/* 45:   */   {
/* 46:95 */     return this.mStringValue;
/* 47:   */   }
/* 48:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.OnlineStatus

 * JD-Core Version:    0.7.0.1

 */