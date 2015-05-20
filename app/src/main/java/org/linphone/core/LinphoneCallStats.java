/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public abstract interface LinphoneCallStats
/*  6:   */ {
/*  7:   */   public abstract MediaType getMediaType();
/*  8:   */   
/*  9:   */   public abstract IceState getIceState();
/* 10:   */   
/* 11:   */   public abstract float getDownloadBandwidth();
/* 12:   */   
/* 13:   */   public abstract float getUploadBandwidth();
/* 14:   */   
/* 15:   */   public abstract float getSenderLossRate();
/* 16:   */   
/* 17:   */   public abstract float getReceiverLossRate();
/* 18:   */   
/* 19:   */   public abstract float getSenderInterarrivalJitter();
/* 20:   */   
/* 21:   */   public abstract float getReceiverInterarrivalJitter();
/* 22:   */   
/* 23:   */   public abstract float getRoundTripDelay();
/* 24:   */   
/* 25:   */   public abstract long getLatePacketsCumulativeNumber();
/* 26:   */   
/* 27:   */   public abstract float getJitterBufferSize();
/* 28:   */   
/* 29:   */   public abstract float getLocalLossRate();
/* 30:   */   
/* 31:   */   public abstract float getLocalLateRate();
/* 32:   */   
/* 33:   */   public static class MediaType
/* 34:   */   {
/* 35:26 */     private static Vector<MediaType> values = new Vector();
/* 36:30 */     public static MediaType Audio = new MediaType(0, "Audio");
/* 37:34 */     public static MediaType Video = new MediaType(1, "Video");
/* 38:   */     protected final int mValue;
/* 39:   */     private final String mStringValue;
/* 40:   */     
/* 41:   */     private MediaType(int value, String stringValue)
/* 42:   */     {
/* 43:39 */       this.mValue = value;
/* 44:40 */       values.addElement(this);
/* 45:41 */       this.mStringValue = stringValue;
/* 46:   */     }
/* 47:   */     
/* 48:   */     public static MediaType fromInt(int value)
/* 49:   */     {
/* 50:44 */       for (int i = 0; i < values.size(); i++)
/* 51:   */       {
/* 52:45 */         MediaType mtype = (MediaType)values.elementAt(i);
/* 53:46 */         if (mtype.mValue == value) {
/* 54:46 */           return mtype;
/* 55:   */         }
/* 56:   */       }
/* 57:48 */       throw new RuntimeException("MediaType not found [" + value + "]");
/* 58:   */     }
/* 59:   */     
/* 60:   */     public String toString()
/* 61:   */     {
/* 62:51 */       return this.mStringValue;
/* 63:   */     }
/* 64:   */   }
/* 65:   */   
/* 66:   */   public static class IceState
/* 67:   */   {
/* 68:55 */     private static Vector<IceState> values = new Vector();
/* 69:59 */     public static IceState NotActivated = new IceState(0, "Not activated");
/* 70:63 */     public static IceState Failed = new IceState(1, "Failed");
/* 71:67 */     public static IceState InProgress = new IceState(2, "In progress");
/* 72:71 */     public static IceState HostConnection = new IceState(3, "Host connection");
/* 73:75 */     public static IceState ReflexiveConnection = new IceState(4, "Reflexive connection");
/* 74:79 */     public static IceState RelayConnection = new IceState(5, "Relay connection");
/* 75:   */     protected final int mValue;
/* 76:   */     private final String mStringValue;
/* 77:   */     
/* 78:   */     private IceState(int value, String stringValue)
/* 79:   */     {
/* 80:84 */       this.mValue = value;
/* 81:85 */       values.addElement(this);
/* 82:86 */       this.mStringValue = stringValue;
/* 83:   */     }
/* 84:   */     
/* 85:   */     public static IceState fromInt(int value)
/* 86:   */     {
/* 87:89 */       for (int i = 0; i < values.size(); i++)
/* 88:   */       {
/* 89:90 */         IceState mstate = (IceState)values.elementAt(i);
/* 90:91 */         if (mstate.mValue == value) {
/* 91:91 */           return mstate;
/* 92:   */         }
/* 93:   */       }
/* 94:93 */       throw new RuntimeException("IceState not found [" + value + "]");
/* 95:   */     }
/* 96:   */     
/* 97:   */     public String toString()
/* 98:   */     {
/* 99:96 */       return this.mStringValue;
/* :0:   */     }
/* :1:   */   }
/* :2:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCallStats
 * JD-Core Version:    0.7.0.1
 */