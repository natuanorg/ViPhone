/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import java.util.Vector;
/*   4:    */ 
/*   5:    */ public abstract interface LinphoneCall
/*   6:    */ {
/*   7:    */   public abstract State getState();
/*   8:    */   
/*   9:    */   public abstract LinphoneAddress getRemoteAddress();
/*  10:    */   
/*  11:    */   public abstract CallDirection getDirection();
/*  12:    */   
/*  13:    */   public abstract LinphoneCallLog getCallLog();
/*  14:    */   
/*  15:    */   public abstract LinphoneCallStats getAudioStats();
/*  16:    */   
/*  17:    */   public abstract LinphoneCallStats getVideoStats();
/*  18:    */   
/*  19:    */   public abstract LinphoneCallParams getRemoteParams();
/*  20:    */   
/*  21:    */   public abstract LinphoneCallParams getCurrentParamsCopy();
/*  22:    */   
/*  23:    */   public abstract void enableCamera(boolean paramBoolean);
/*  24:    */   
/*  25:    */   public abstract boolean cameraEnabled();
/*  26:    */   
/*  27:    */   public abstract void enableEchoCancellation(boolean paramBoolean);
/*  28:    */   
/*  29:    */   public abstract boolean isEchoCancellationEnabled();
/*  30:    */   
/*  31:    */   public abstract void enableEchoLimiter(boolean paramBoolean);
/*  32:    */   
/*  33:    */   public abstract boolean isEchoLimiterEnabled();
/*  34:    */   
/*  35:    */   public abstract LinphoneCall getReplacedCall();
/*  36:    */   
/*  37:    */   public abstract int getDuration();
/*  38:    */   
/*  39:    */   public abstract float getCurrentQuality();
/*  40:    */   
/*  41:    */   public abstract float getAverageQuality();
/*  42:    */   
/*  43:    */   public abstract String getAuthenticationToken();
/*  44:    */   
/*  45:    */   public abstract boolean isAuthenticationTokenVerified();
/*  46:    */   
/*  47:    */   public abstract void setAuthenticationTokenVerified(boolean paramBoolean);
/*  48:    */   
/*  49:    */   public abstract boolean isInConference();
/*  50:    */   
/*  51:    */   public abstract boolean mediaInProgress();
/*  52:    */   
/*  53:    */   public abstract float getPlayVolume();
/*  54:    */   
/*  55:    */   public abstract String getRemoteUserAgent();
/*  56:    */   
/*  57:    */   public abstract String getRemoteContact();
/*  58:    */   
/*  59:    */   public abstract void takeSnapshot(String paramString);
/*  60:    */   
/*  61:    */   public abstract void zoomVideo(float paramFloat1, float paramFloat2, float paramFloat3);
/*  62:    */   
/*  63:    */   public abstract void startRecording();
/*  64:    */   
/*  65:    */   public abstract void stopRecording();
/*  66:    */   
/*  67:    */   public abstract State getTransferState();
/*  68:    */   
/*  69:    */   public abstract void sendInfoMessage(LinphoneInfoMessage paramLinphoneInfoMessage);
/*  70:    */   
/*  71:    */   public abstract LinphoneCall getTransfererCall();
/*  72:    */   
/*  73:    */   public abstract LinphoneCall getTransferTargetCall();
/*  74:    */   
/*  75:    */   public abstract Reason getReason();
/*  76:    */   
/*  77:    */   public abstract ErrorInfo getErrorInfo();
/*  78:    */   
/*  79:    */   public abstract void setUserData(Object paramObject);
/*  80:    */   
/*  81:    */   public abstract Object getUserData();
/*  82:    */   
/*  83:    */   public abstract LinphonePlayer getPlayer();
/*  84:    */   
/*  85:    */   public static class State
/*  86:    */   {
/*  87: 35 */     private static Vector<State> values = new Vector();
/*  88:    */     private final int mValue;
/*  89:    */     private final String mStringValue;
/*  90:    */     
/*  91:    */     public final int value()
/*  92:    */     {
/*  93: 37 */       return this.mValue;
/*  94:    */     }
/*  95:    */     
/*  96: 43 */     public static final State Idle = new State(0, "Idle");
/*  97: 47 */     public static final State IncomingReceived = new State(1, "IncomingReceived");
/*  98: 51 */     public static final State OutgoingInit = new State(2, "OutgoingInit");
/*  99: 55 */     public static final State OutgoingProgress = new State(3, "OutgoingProgress");
/* 100: 59 */     public static final State OutgoingRinging = new State(4, "OutgoingRinging");
/* 101: 63 */     public static final State OutgoingEarlyMedia = new State(5, "OutgoingEarlyMedia");
/* 102: 67 */     public static final State Connected = new State(6, "Connected");
/* 103: 71 */     public static final State StreamsRunning = new State(7, "StreamsRunning");
/* 104: 75 */     public static final State Pausing = new State(8, "Pausing");
/* 105: 79 */     public static final State Paused = new State(9, "Paused");
/* 106: 83 */     public static final State Resuming = new State(10, "Resuming");
/* 107: 87 */     public static final State Refered = new State(11, "Refered");
/* 108: 91 */     public static final State Error = new State(12, "Error");
/* 109: 95 */     public static final State CallEnd = new State(13, "CallEnd");
/* 110:100 */     public static final State PausedByRemote = new State(14, "PausedByRemote");
/* 111:105 */     public static final State CallUpdatedByRemote = new State(15, "UpdatedByRemote");
/* 112:110 */     public static final State CallIncomingEarlyMedia = new State(16, "IncomingEarlyMedia");
/* 113:115 */     public static final State CallUpdating = new State(17, "Updating");
/* 114:120 */     public static final State CallReleased = new State(18, "Released");
/* 115:125 */     public static final State CallEarlyUpdatedByRemote = new State(19, "EarlyUpdatedByRemote");
/* 116:130 */     public static final State CallEarlyUpdating = new State(20, "EarlyUpdating");
/* 117:    */     
/* 118:    */     private State(int value, String stringValue)
/* 119:    */     {
/* 120:133 */       this.mValue = value;
/* 121:134 */       values.addElement(this);
/* 122:135 */       this.mStringValue = stringValue;
/* 123:    */     }
/* 124:    */     
/* 125:    */     public static State fromInt(int value)
/* 126:    */     {
/* 127:140 */       for (int i = 0; i < values.size(); i++)
/* 128:    */       {
/* 129:141 */         State state = (State)values.elementAt(i);
/* 130:142 */         if (state.mValue == value) {
/* 131:142 */           return state;
/* 132:    */         }
/* 133:    */       }
/* 134:144 */       throw new RuntimeException("state not found [" + value + "]");
/* 135:    */     }
/* 136:    */     
/* 137:    */     public String toString()
/* 138:    */     {
/* 139:147 */       return this.mStringValue;
/* 140:    */     }
/* 141:    */   }
/* 142:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneCall
 * JD-Core Version:    0.7.0.1
 */