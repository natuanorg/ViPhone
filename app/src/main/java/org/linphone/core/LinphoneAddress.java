/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public abstract interface LinphoneAddress
/*  6:   */ {
/*  7:   */   public abstract String getDisplayName();
/*  8:   */   
/*  9:   */   public abstract String getUserName();
/* 10:   */   
/* 11:   */   public abstract String getDomain();
/* 12:   */   
/* 13:   */   public abstract int getPort();
/* 14:   */   
/* 15:   */   public abstract void setDisplayName(String paramString);
/* 16:   */   
/* 17:   */   public abstract void setUserName(String paramString);
/* 18:   */   
/* 19:   */   public abstract void setDomain(String paramString);
/* 20:   */   
/* 21:   */   public abstract void setPort(int paramInt);
/* 22:   */   
/* 23:   */   public abstract void clean();
/* 24:   */   
/* 25:   */   public abstract String asString();
/* 26:   */   
/* 27:   */   public abstract String asStringUriOnly();
/* 28:   */   
/* 29:   */   public abstract String toString();
/* 30:   */   
/* 31:   */   public abstract TransportType getTransport();
/* 32:   */   
/* 33:   */   public abstract void setTransport(TransportType paramTransportType);
/* 34:   */   
/* 35:   */   public static class TransportType
/* 36:   */   {
/* 37:35 */     private static Vector<TransportType> values = new Vector();
/* 38:36 */     public static TransportType LinphoneTransportUdp = new TransportType(0, "LinphoneTransportUdp");
/* 39:37 */     public static TransportType LinphoneTransportTcp = new TransportType(1, "LinphoneTransportTcp");
/* 40:38 */     public static TransportType LinphoneTransportTls = new TransportType(2, "LinphoneTransportTls");
/* 41:   */     private final int mValue;
/* 42:   */     private final String mStringValue;
/* 43:   */     
/* 44:   */     private TransportType(int value, String stringValue)
/* 45:   */     {
/* 46:44 */       this.mValue = value;
/* 47:45 */       values.addElement(this);
/* 48:46 */       this.mStringValue = stringValue;
/* 49:   */     }
/* 50:   */     
/* 51:   */     public static TransportType fromInt(int value)
/* 52:   */     {
/* 53:50 */       for (int i = 0; i < values.size(); i++)
/* 54:   */       {
/* 55:51 */         TransportType type = (TransportType)values.elementAt(i);
/* 56:52 */         if (type.mValue == value) {
/* 57:52 */           return type;
/* 58:   */         }
/* 59:   */       }
/* 60:54 */       throw new RuntimeException("state not found [" + value + "]");
/* 61:   */     }
/* 62:   */     
/* 63:   */     public String toString()
/* 64:   */     {
/* 65:58 */       return this.mStringValue;
/* 66:   */     }
/* 67:   */     
/* 68:   */     public int toInt()
/* 69:   */     {
/* 70:62 */       return this.mValue;
/* 71:   */     }
/* 72:   */   }
/* 73:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneAddress
 * JD-Core Version:    0.7.0.1
 */