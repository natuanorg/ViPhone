/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LinphoneCallStatsImpl
/*   4:    */   implements LinphoneCallStats
/*   5:    */ {
/*   6:    */   private int mediaType;
/*   7:    */   private int iceState;
/*   8:    */   private float downloadBandwidth;
/*   9:    */   private float uploadBandwidth;
/*  10:    */   private float senderLossRate;
/*  11:    */   private float receiverLossRate;
/*  12:    */   private float senderInterarrivalJitter;
/*  13:    */   private float receiverInterarrivalJitter;
/*  14:    */   private float roundTripDelay;
/*  15:    */   private long latePacketsCumulativeNumber;
/*  16:    */   private float jitterBufferSize;
/*  17:    */   private float localLossRate;
/*  18:    */   private float localLateRate;
/*  19:    */   private long nativePtr;
/*  20:    */   
/*  21:    */   private native int getMediaType(long paramLong);
/*  22:    */   
/*  23:    */   private native int getIceState(long paramLong);
/*  24:    */   
/*  25:    */   private native float getDownloadBandwidth(long paramLong);
/*  26:    */   
/*  27:    */   private native float getUploadBandwidth(long paramLong);
/*  28:    */   
/*  29:    */   private native float getSenderLossRate(long paramLong);
/*  30:    */   
/*  31:    */   private native float getReceiverLossRate(long paramLong);
/*  32:    */   
/*  33:    */   private native float getSenderInterarrivalJitter(long paramLong1, long paramLong2);
/*  34:    */   
/*  35:    */   private native float getReceiverInterarrivalJitter(long paramLong1, long paramLong2);
/*  36:    */   
/*  37:    */   private native float getRoundTripDelay(long paramLong);
/*  38:    */   
/*  39:    */   private native long getLatePacketsCumulativeNumber(long paramLong1, long paramLong2);
/*  40:    */   
/*  41:    */   private native float getJitterBufferSize(long paramLong);
/*  42:    */   
/*  43:    */   private native float getLocalLossRate(long paramLong);
/*  44:    */   
/*  45:    */   private native float getLocalLateRate(long paramLong);
/*  46:    */   
/*  47:    */   private native void updateStats(long paramLong, int paramInt);
/*  48:    */   
/*  49:    */   protected LinphoneCallStatsImpl(long nativeCallPtr, long nativeStatsPtr)
/*  50:    */   {
/*  51: 54 */     this.nativePtr = nativeStatsPtr;
/*  52: 55 */     this.mediaType = getMediaType(nativeStatsPtr);
/*  53: 56 */     this.iceState = getIceState(nativeStatsPtr);
/*  54: 57 */     this.downloadBandwidth = getDownloadBandwidth(nativeStatsPtr);
/*  55: 58 */     this.uploadBandwidth = getUploadBandwidth(nativeStatsPtr);
/*  56: 59 */     this.senderLossRate = getSenderLossRate(nativeStatsPtr);
/*  57: 60 */     this.receiverLossRate = getReceiverLossRate(nativeStatsPtr);
/*  58: 61 */     this.senderInterarrivalJitter = getSenderInterarrivalJitter(nativeStatsPtr, nativeCallPtr);
/*  59: 62 */     this.receiverInterarrivalJitter = getReceiverInterarrivalJitter(nativeStatsPtr, nativeCallPtr);
/*  60: 63 */     this.roundTripDelay = getRoundTripDelay(nativeStatsPtr);
/*  61: 64 */     this.latePacketsCumulativeNumber = getLatePacketsCumulativeNumber(nativeStatsPtr, nativeCallPtr);
/*  62: 65 */     this.jitterBufferSize = getJitterBufferSize(nativeStatsPtr);
/*  63:    */   }
/*  64:    */   
/*  65:    */   protected void updateRealTimeStats(LinphoneCall call)
/*  66:    */   {
/*  67: 70 */     updateStats(((LinphoneCallImpl)call).nativePtr, this.mediaType);
/*  68: 71 */     this.localLossRate = getLocalLossRate(this.nativePtr);
/*  69: 72 */     this.localLateRate = getLocalLateRate(this.nativePtr);
/*  70:    */   }
/*  71:    */   
/*  72:    */   public MediaType getMediaType()
/*  73:    */   {
/*  74: 76 */     return MediaType.fromInt(this.mediaType);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public IceState getIceState()
/*  78:    */   {
/*  79: 80 */     return IceState.fromInt(this.iceState);
/*  80:    */   }
/*  81:    */   
/*  82:    */   public float getDownloadBandwidth()
/*  83:    */   {
/*  84: 84 */     return this.downloadBandwidth;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public float getUploadBandwidth()
/*  88:    */   {
/*  89: 88 */     return this.uploadBandwidth;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public float getSenderLossRate()
/*  93:    */   {
/*  94: 92 */     return this.senderLossRate;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public float getReceiverLossRate()
/*  98:    */   {
/*  99: 96 */     return this.receiverLossRate;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public float getSenderInterarrivalJitter()
/* 103:    */   {
/* 104:100 */     return this.senderInterarrivalJitter;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public float getReceiverInterarrivalJitter()
/* 108:    */   {
/* 109:104 */     return this.receiverInterarrivalJitter;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public float getRoundTripDelay()
/* 113:    */   {
/* 114:108 */     return this.roundTripDelay;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public long getLatePacketsCumulativeNumber()
/* 118:    */   {
/* 119:112 */     return this.latePacketsCumulativeNumber;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public float getJitterBufferSize()
/* 123:    */   {
/* 124:116 */     return this.jitterBufferSize;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public float getLocalLossRate()
/* 128:    */   {
/* 129:120 */     return this.localLossRate;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public float getLocalLateRate()
/* 133:    */   {
/* 134:124 */     return this.localLateRate;
/* 135:    */   }
/* 136:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCallStatsImpl

 * JD-Core Version:    0.7.0.1

 */