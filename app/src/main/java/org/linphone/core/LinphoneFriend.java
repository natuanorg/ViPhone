/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public abstract interface LinphoneFriend
/*  6:   */ {
/*  7:   */   public abstract void setAddress(LinphoneAddress paramLinphoneAddress);
/*  8:   */   
/*  9:   */   public abstract LinphoneAddress getAddress();
/* 10:   */   
/* 11:   */   public abstract void setIncSubscribePolicy(SubscribePolicy paramSubscribePolicy);
/* 12:   */   
/* 13:   */   public abstract SubscribePolicy getIncSubscribePolicy();
/* 14:   */   
/* 15:   */   public abstract void enableSubscribes(boolean paramBoolean);
/* 16:   */   
/* 17:   */   public abstract boolean isSubscribesEnabled();
/* 18:   */   
/* 19:   */
/* 22:   */   public abstract OnlineStatus getStatus();
/* 23:   */   
/* 24:   */   public abstract PresenceModel getPresenceModel();
/* 25:   */   
/* 26:   */   public abstract void edit();
/* 27:   */   
/* 28:   */   public abstract void done();
/* 29:   */   
/* 30:   */   public abstract String toString();
/* 31:   */   
/* 32:   */   public abstract long getNativePtr();
/* 33:   */   
/* 34:   */   public abstract void setRefKey(String paramString);
/* 35:   */   
/* 36:   */   public abstract String getRefKey();
/* 37:   */   
/* 38:   */   public static class SubscribePolicy
/* 39:   */   {
/* 40:40 */     private static Vector<SubscribePolicy> values = new Vector();
/* 41:   */     protected final int mValue;
/* 42:   */     private final String mStringValue;
/* 43:47 */     public static final SubscribePolicy SPWait = new SubscribePolicy(0, "SPWait");
/* 44:51 */     public static final SubscribePolicy SPDeny = new SubscribePolicy(1, "SPDeny");
/* 45:55 */     public static final SubscribePolicy SPAccept = new SubscribePolicy(2, "SPAccept");
/* 46:   */     
/* 47:   */     private SubscribePolicy(int value, String stringValue)
/* 48:   */     {
/* 49:59 */       this.mValue = value;
/* 50:60 */       values.addElement(this);
/* 51:61 */       this.mStringValue = stringValue;
/* 52:   */     }
/* 53:   */     
/* 54:   */     public static SubscribePolicy fromInt(int value)
/* 55:   */     {
/* 56:65 */       for (int i = 0; i < values.size(); i++)
/* 57:   */       {
/* 58:66 */         SubscribePolicy policy = (SubscribePolicy)values.elementAt(i);
/* 59:67 */         if (policy.mValue == value) {
/* 60:67 */           return policy;
/* 61:   */         }
/* 62:   */       }
/* 63:69 */       throw new RuntimeException("Policy not found [" + value + "]");
/* 64:   */     }
/* 65:   */     
/* 66:   */     public String toString()
/* 67:   */     {
/* 68:72 */       return this.mStringValue;
/* 69:   */     }
/* 70:   */   }
/* 71:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneFriend

 * JD-Core Version:    0.7.0.1

 */