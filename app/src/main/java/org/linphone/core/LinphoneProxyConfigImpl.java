/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LinphoneProxyConfigImpl
/*   4:    */   implements LinphoneProxyConfig
/*   5:    */ {
/*   6:    */   protected final long nativePtr;
/*   7:    */   protected LinphoneCoreImpl mCore;
/*   8:    */   Object userData;
/*   9:    */   
/*  10:    */   private native void finalize(long paramLong);
/*  11:    */   
/*  12:    */   private native int getState(long paramLong);
/*  13:    */   
/*  14:    */   private native void setExpires(long paramLong, int paramInt);
/*  15:    */   
/*  16:    */   private native int getExpires(long paramLong);
/*  17:    */   
/*  18:    */   private native long createProxyConfig(long paramLong);
/*  19:    */   
/*  20:    */   protected LinphoneProxyConfigImpl(LinphoneCoreImpl core, String identity, String proxy, String route, boolean enableRegister)
/*  21:    */     throws LinphoneCoreException
/*  22:    */   {
/*  23: 36 */     this.mCore = core;
/*  24: 37 */     this.nativePtr = createProxyConfig(core.nativePtr);
/*  25: 38 */     setIdentity(identity);
/*  26: 39 */     setProxy(proxy);
/*  27: 40 */     setRoute(route);
/*  28: 41 */     enableRegister(enableRegister);
/*  29:    */   }
/*  30:    */   
/*  31:    */   protected LinphoneProxyConfigImpl(LinphoneCoreImpl core)
/*  32:    */   {
/*  33: 45 */     this.mCore = core;
/*  34: 46 */     this.nativePtr = createProxyConfig(core.nativePtr);
/*  35:    */   }
/*  36:    */   
/*  37:    */   protected LinphoneProxyConfigImpl(LinphoneCoreImpl core, long aNativePtr)
/*  38:    */   {
/*  39: 50 */     this.mCore = core;
/*  40: 51 */     this.nativePtr = aNativePtr;
/*  41:    */   }
/*  42:    */   
/*  43:    */   private void isValid()
/*  44:    */   {
/*  45: 55 */     if (this.nativePtr == 0L) {
/*  46: 56 */       throw new RuntimeException("proxy config removed");
/*  47:    */     }
/*  48:    */   }
/*  49:    */   
/*  50:    */   protected void finalize()
/*  51:    */     throws Throwable
/*  52:    */   {
/*  53: 61 */     if (this.nativePtr != 0L) {
/*  54: 62 */       finalize(this.nativePtr);
/*  55:    */     }
/*  56: 64 */     super.finalize();
/*  57:    */   }
/*  58:    */   
/*  59:    */   private native long newLinphoneProxyConfig();
/*  60:    */   
/*  61:    */   private native void edit(long paramLong);
/*  62:    */   
/*  63:    */   private native void done(long paramLong);
/*  64:    */   
/*  65:    */   private native void setIdentity(long paramLong, String paramString);
/*  66:    */   
/*  67:    */   private native String getIdentity(long paramLong);
/*  68:    */   
/*  69:    */   private native int setProxy(long paramLong, String paramString);
/*  70:    */   
/*  71:    */   private native String getProxy(long paramLong);
/*  72:    */   
/*  73:    */   private native void enableRegister(long paramLong, boolean paramBoolean);
/*  74:    */   
/*  75:    */   private native boolean isRegisterEnabled(long paramLong);
/*  76:    */   
/*  77:    */   private native boolean isRegistered(long paramLong);
/*  78:    */   
/*  79:    */   private native void setDialPrefix(long paramLong, String paramString);
/*  80:    */   
/*  81:    */   private native String getDialPrefix(long paramLong);
/*  82:    */   
/*  83:    */   private native String normalizePhoneNumber(long paramLong, String paramString);
/*  84:    */   
/*  85:    */   private native String getDomain(long paramLong);
/*  86:    */   
/*  87:    */   private native void setDialEscapePlus(long paramLong, boolean paramBoolean);
/*  88:    */   
/*  89:    */   private native boolean getDialEscapePlus(long paramLong);
/*  90:    */   
/*  91:    */   private native String getRoute(long paramLong);
/*  92:    */   
/*  93:    */   private native int setRoute(long paramLong, String paramString);
/*  94:    */   
/*  95:    */   private native void enablePublish(long paramLong, boolean paramBoolean);
/*  96:    */   
/*  97:    */   private native boolean publishEnabled(long paramLong);
/*  98:    */   
/*  99:    */   private native void setContactParameters(long paramLong, String paramString);
/* 100:    */   
/* 101:    */   private native int lookupCCCFromIso(long paramLong, String paramString);
/* 102:    */   
/* 103:    */   private native int lookupCCCFromE164(long paramLong, String paramString);
/* 104:    */   
/* 105:    */   public LinphoneProxyConfig enableRegister(boolean value)
/* 106:    */   {
/* 107:101 */     isValid();
/* 108:102 */     enableRegister(this.nativePtr, value);
/* 109:103 */     return this;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void done()
/* 113:    */   {
/* 114:107 */     isValid();
/* 115:108 */     Object mutex = this.mCore != null ? this.mCore : this;
/* 116:109 */     synchronized (mutex)
/* 117:    */     {
/* 118:110 */       done(this.nativePtr);
/* 119:    */     }
/* 120:    */   }
/* 121:    */   
/* 122:    */   public LinphoneProxyConfig edit()
/* 123:    */   {
/* 124:115 */     isValid();
/* 125:116 */     Object mutex = this.mCore != null ? this.mCore : this;
/* 126:117 */     synchronized (mutex)
/* 127:    */     {
/* 128:118 */       edit(this.nativePtr);
/* 129:    */     }
/* 130:120 */     return this;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setIdentity(String identity)
/* 134:    */     throws LinphoneCoreException
/* 135:    */   {
/* 136:124 */     isValid();
/* 137:125 */     setIdentity(this.nativePtr, identity);
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setProxy(String proxyUri)
/* 141:    */     throws LinphoneCoreException
/* 142:    */   {
/* 143:129 */     isValid();
/* 144:130 */     if (setProxy(this.nativePtr, proxyUri) != 0) {
/* 145:131 */       throw new LinphoneCoreException("Bad proxy address [" + proxyUri + "]");
/* 146:    */     }
/* 147:    */   }
/* 148:    */   
/* 149:    */   public String normalizePhoneNumber(String number)
/* 150:    */   {
/* 151:135 */     isValid();
/* 152:136 */     return normalizePhoneNumber(this.nativePtr, number);
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setDialPrefix(String prefix)
/* 156:    */   {
/* 157:139 */     isValid();
/* 158:140 */     setDialPrefix(this.nativePtr, prefix);
/* 159:    */   }
/* 160:    */   
/* 161:    */   public String getDialPrefix()
/* 162:    */   {
/* 163:143 */     isValid();
/* 164:144 */     return getDialPrefix(this.nativePtr);
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getDomain()
/* 168:    */   {
/* 169:147 */     isValid();
/* 170:148 */     return getDomain(this.nativePtr);
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setDialEscapePlus(boolean value)
/* 174:    */   {
/* 175:151 */     isValid();
/* 176:152 */     setDialEscapePlus(this.nativePtr, value);
/* 177:    */   }
/* 178:    */   
/* 179:    */   public boolean getDialEscapePlus()
/* 180:    */   {
/* 181:155 */     isValid();
/* 182:156 */     return getDialEscapePlus(this.nativePtr);
/* 183:    */   }
/* 184:    */   
/* 185:    */   public String getIdentity()
/* 186:    */   {
/* 187:159 */     isValid();
/* 188:160 */     return getIdentity(this.nativePtr);
/* 189:    */   }
/* 190:    */   
/* 191:    */   public String getProxy()
/* 192:    */   {
/* 193:163 */     isValid();
/* 194:164 */     return getProxy(this.nativePtr);
/* 195:    */   }
/* 196:    */   
/* 197:    */   public boolean isRegistered()
/* 198:    */   {
/* 199:167 */     isValid();
/* 200:168 */     return isRegistered(this.nativePtr);
/* 201:    */   }
/* 202:    */   
/* 203:    */   public boolean registerEnabled()
/* 204:    */   {
/* 205:171 */     isValid();
/* 206:172 */     return isRegisterEnabled(this.nativePtr);
/* 207:    */   }
/* 208:    */   
/* 209:    */   public String getRoute()
/* 210:    */   {
/* 211:175 */     isValid();
/* 212:176 */     return getRoute(this.nativePtr);
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setRoute(String routeUri)
/* 216:    */     throws LinphoneCoreException
/* 217:    */   {
/* 218:179 */     isValid();
/* 219:180 */     if (setRoute(this.nativePtr, routeUri) != 0) {
/* 220:181 */       throw new LinphoneCoreException("cannot set route [" + routeUri + "]");
/* 221:    */     }
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void enablePublish(boolean enable)
/* 225:    */   {
/* 226:185 */     isValid();
/* 227:186 */     enablePublish(this.nativePtr, enable);
/* 228:    */   }
/* 229:    */   
/* 230:    */   public LinphoneCore.RegistrationState getState()
/* 231:    */   {
/* 232:189 */     isValid();
/* 233:190 */     return LinphoneCore.RegistrationState.fromInt(getState(this.nativePtr));
/* 234:    */   }
/* 235:    */   
/* 236:    */   public void setExpires(int delay)
/* 237:    */   {
/* 238:194 */     isValid();
/* 239:195 */     setExpires(this.nativePtr, delay);
/* 240:    */   }
/* 241:    */   
/* 242:    */   public int getExpires()
/* 243:    */   {
/* 244:198 */     isValid();
/* 245:199 */     return getExpires(this.nativePtr);
/* 246:    */   }
/* 247:    */   
/* 248:    */   public boolean publishEnabled()
/* 249:    */   {
/* 250:202 */     isValid();
/* 251:203 */     return publishEnabled(this.nativePtr);
/* 252:    */   }
/* 253:    */   
/* 254:    */   public void setContactParameters(String params)
/* 255:    */   {
/* 256:207 */     isValid();
/* 257:208 */     setContactParameters(this.nativePtr, params);
/* 258:    */   }
/* 259:    */   
/* 260:    */   public int lookupCCCFromIso(String iso)
/* 261:    */   {
/* 262:212 */     isValid();
/* 263:213 */     return lookupCCCFromIso(this.nativePtr, iso);
/* 264:    */   }
/* 265:    */   
/* 266:    */   public int lookupCCCFromE164(String e164)
/* 267:    */   {
/* 268:217 */     isValid();
/* 269:218 */     return lookupCCCFromE164(this.nativePtr, e164);
/* 270:    */   }
/* 271:    */   
/* 272:    */   private native int getError(long paramLong);
/* 273:    */   
/* 274:    */   public Reason getError()
/* 275:    */   {
/* 276:223 */     isValid();
/* 277:224 */     return Reason.fromInt(getError(this.nativePtr));
/* 278:    */   }
/* 279:    */   
/* 280:    */   private native void setPrivacy(long paramLong, int paramInt);
/* 281:    */   
/* 282:    */   public void setPrivacy(int privacy_mask)
/* 283:    */   {
/* 284:229 */     isValid();
/* 285:230 */     setPrivacy(this.nativePtr, privacy_mask);
/* 286:    */   }
/* 287:    */   
/* 288:    */   private native int getPrivacy(long paramLong);
/* 289:    */   
/* 290:    */   public int getPrivacy()
/* 291:    */   {
/* 292:236 */     isValid();
/* 293:237 */     return getPrivacy(this.nativePtr);
/* 294:    */   }
/* 295:    */   
/* 296:    */   private native void enableAvpf(long paramLong, boolean paramBoolean);
/* 297:    */   
/* 298:    */   public void enableAvpf(boolean enable)
/* 299:    */   {
/* 300:243 */     isValid();
/* 301:244 */     enableAvpf(this.nativePtr, enable);
/* 302:    */   }
/* 303:    */   
/* 304:    */   private native boolean avpfEnabled(long paramLong);
/* 305:    */   
/* 306:    */   public boolean avpfEnabled()
/* 307:    */   {
/* 308:250 */     isValid();
/* 309:251 */     return avpfEnabled(this.nativePtr);
/* 310:    */   }
/* 311:    */   
/* 312:    */   private native void setAvpfRRInterval(long paramLong, int paramInt);
/* 313:    */   
/* 314:    */   public void setAvpfRRInterval(int interval)
/* 315:    */   {
/* 316:257 */     isValid();
/* 317:258 */     setAvpfRRInterval(this.nativePtr, interval);
/* 318:    */   }
/* 319:    */   
/* 320:    */   private native int getAvpfRRInterval(long paramLong);
/* 321:    */   
/* 322:    */   public int getAvpfRRInterval()
/* 323:    */   {
/* 324:264 */     isValid();
/* 325:265 */     return getAvpfRRInterval(this.nativePtr);
/* 326:    */   }
/* 327:    */   
/* 328:    */   private native String getContactParameters(long paramLong);
/* 329:    */   
/* 330:    */   public String getContactParameters()
/* 331:    */   {
/* 332:271 */     isValid();
/* 333:272 */     return getContactParameters(this.nativePtr);
/* 334:    */   }
/* 335:    */   
/* 336:    */   private native void setContactUriParameters(long paramLong, String paramString);
/* 337:    */   
/* 338:    */   public void setContactUriParameters(String params)
/* 339:    */   {
/* 340:278 */     isValid();
/* 341:279 */     setContactUriParameters(this.nativePtr, params);
/* 342:    */   }
/* 343:    */   
/* 344:    */   private native String getContactUriParameters(long paramLong);
/* 345:    */   
/* 346:    */   public String getContactUriParameters()
/* 347:    */   {
/* 348:285 */     isValid();
/* 349:286 */     return getContactUriParameters(this.nativePtr);
/* 350:    */   }
/* 351:    */   
/* 352:    */   private native long getErrorInfo(long paramLong);
/* 353:    */   
/* 354:    */   public ErrorInfo getErrorInfo()
/* 355:    */   {
/* 356:293 */     return new ErrorInfoImpl(getErrorInfo(this.nativePtr));
/* 357:    */   }
/* 358:    */   
/* 359:    */   private native void enableQualityReporting(long paramLong, boolean paramBoolean);
/* 360:    */   
/* 361:    */   public void enableQualityReporting(boolean enable)
/* 362:    */   {
/* 363:299 */     isValid();
/* 364:300 */     enableQualityReporting(this.nativePtr, enable);
/* 365:    */   }
/* 366:    */   
/* 367:    */   private native boolean qualityReportingEnabled(long paramLong);
/* 368:    */   
/* 369:    */   public boolean qualityReportingEnabled()
/* 370:    */   {
/* 371:306 */     isValid();
/* 372:307 */     return avpfEnabled(this.nativePtr);
/* 373:    */   }
/* 374:    */   
/* 375:    */   private native void setQualityReportingInterval(long paramLong, int paramInt);
/* 376:    */   
/* 377:    */   public void setQualityReportingInterval(int interval)
/* 378:    */   {
/* 379:313 */     isValid();
/* 380:314 */     setQualityReportingInterval(this.nativePtr, interval);
/* 381:    */   }
/* 382:    */   
/* 383:    */   private native int getQualityReportingInterval(long paramLong);
/* 384:    */   
/* 385:    */   public int getQualityReportingInterval()
/* 386:    */   {
/* 387:319 */     isValid();
/* 388:320 */     return getQualityReportingInterval(this.nativePtr);
/* 389:    */   }
/* 390:    */   
/* 391:    */   private native void setQualityReportingCollector(long paramLong, String paramString);
/* 392:    */   
/* 393:    */   public void setQualityReportingCollector(String collector)
/* 394:    */   {
/* 395:326 */     isValid();
/* 396:327 */     setQualityReportingCollector(this.nativePtr, collector);
/* 397:    */   }
/* 398:    */   
/* 399:    */   private native String getQualityReportingCollector(long paramLong);
/* 400:    */   
/* 401:    */   public String getQualityReportingCollector()
/* 402:    */   {
/* 403:333 */     isValid();
/* 404:334 */     return getQualityReportingCollector(this.nativePtr);
/* 405:    */   }
/* 406:    */   
/* 407:    */   private native void setRealm(long paramLong, String paramString);
/* 408:    */   
/* 409:    */   public void setRealm(String realm)
/* 410:    */   {
/* 411:340 */     isValid();
/* 412:341 */     setRealm(this.nativePtr, realm);
/* 413:    */   }
/* 414:    */   
/* 415:    */   private native String getRealm(long paramLong);
/* 416:    */   
/* 417:    */   public String getRealm()
/* 418:    */   {
/* 419:347 */     isValid();
/* 420:348 */     return getRealm(this.nativePtr);
/* 421:    */   }
/* 422:    */   
/* 423:    */   private native void setPublishExpires(long paramLong, int paramInt);
/* 424:    */   
/* 425:    */   public void setPublishExpires(int expires)
/* 426:    */   {
/* 427:354 */     isValid();
/* 428:355 */     setPublishExpires(this.nativePtr, expires);
/* 429:    */   }
/* 430:    */   
/* 431:    */   private native int getPublishExpires(long paramLong);
/* 432:    */   
/* 433:    */   public int getPublishExpires()
/* 434:    */   {
/* 435:361 */     isValid();
/* 436:362 */     return getPublishExpires(this.nativePtr);
/* 437:    */   }
/* 438:    */   
/* 439:    */   private native boolean isPhoneNumber(long paramLong, String paramString);
/* 440:    */   
/* 441:    */   public boolean isPhoneNumber(String username)
/* 442:    */   {
/* 443:368 */     return isPhoneNumber(this.nativePtr, username);
/* 444:    */   }
/* 445:    */   
/* 446:    */   public void setUserData(Object obj)
/* 447:    */   {
/* 448:373 */     this.userData = obj;
/* 449:    */   }
/* 450:    */   
/* 451:    */   public Object getUserData()
/* 452:    */   {
/* 453:377 */     return this.userData;
/* 454:    */   }
/* 455:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneProxyConfigImpl
 * JD-Core Version:    0.7.0.1
 */