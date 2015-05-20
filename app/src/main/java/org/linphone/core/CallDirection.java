/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class CallDirection
/*  4:   */ {
/*  5:28 */   public static CallDirection Outgoing = new CallDirection("CallOutgoing");
/*  6:32 */   public static CallDirection Incoming = new CallDirection("Callincoming");
/*  7:   */   private String mStringValue;
/*  8:   */   
/*  9:   */   private CallDirection(String aStringValue)
/* 10:   */   {
/* 11:35 */     this.mStringValue = aStringValue;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String toString()
/* 15:   */   {
/* 16:38 */     return this.mStringValue;
/* 17:   */   }
/* 18:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.CallDirection
 * JD-Core Version:    0.7.0.1
 */