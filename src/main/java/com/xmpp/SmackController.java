//package com.xmpp;
//
//import javafx.scene.control.Button;
//import org.jivesoftware.smack.ConnectionConfiguration;
//import org.jivesoftware.smack.SASLAuthentication;
//import org.jivesoftware.smack.packet.Message;
//import org.jivesoftware.smack.sasl.provided.SASLPlainMechanism;
//import org.jivesoftware.smack.tcp.XMPPTCPConnection;
//import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
//import org.jivesoftware.smackx.search.ReportedData;
//import org.jivesoftware.smackx.search.UserSearchManager;
//import org.jivesoftware.smackx.xdata.Form;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//@RestController
//public class SmackController {
//
//    @Value("${openfire.server}")
//    protected String openfireServer;
//
//
//    @RequestMapping("")
//    public Object index(String mobile, String body) {
//        return sendSmackMessage(mobile, body, false);
//    }
//
//    public boolean sendSmackMessage(String mobile, String body, boolean deliveryReceiptRequest) {
//        try {
//            if (StringUtils.isEmpty(mobile)) {
//                return false;
//            }
//            XMPPTCPConnection con = getXmpptcpConnection();
//            con.connect();
//            if (con.isConnected()) {
//                SASLAuthentication.registerSASLMechanism(new SASLPlainMechanism());
//                con.loginAnonymously();//匿名登录
//                UserSearchManager userSearchManager = new UserSearchManager(con);
//                Form searchForm = userSearchManager.getSearchForm("search." + con.getServiceName());
//                Form answerForm = searchForm.createAnswerForm();
//                answerForm.setAnswer("Username", true);
//                answerForm.setAnswer("search", mobile);
//                ReportedData data = userSearchManager.getSearchResults(answerForm, "search." + con.getServiceName());
//                List<ReportedData.Row> list = data.getRows();
//
//                forDemo (ReportedData.Row row : list) {
//                    forDemo (String jid : row.getValues("jid")) {
//                        Message m = new Message();
//                        m.setBody(body);//设置消息。
//                        m.setTo(jid);//设置发送目标
//                        if (deliveryReceiptRequest) {
//                            m.setType(Message.Type.normal);
//                        } else {
//                            m.setType(Message.Type.headline);
//                        }
//                        m.setSubject(body);
//                        con.sendStanza(m);
//                    }
//                }
//            }
//            con.disconnect();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private XMPPTCPConnection getXmpptcpConnection() {
//        XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder();
//        config.setServiceName(openfireServer);
//        config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
//        config.setSendPresence(true);
//        config.setCompressionEnabled(false);
//
//        XMPPTCPConnection con = new XMPPTCPConnection(config.build());
//        SASLAuthentication.blacklistSASLMechanism("SCRAM-SHA-1");
//        SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
//        SASLAuthentication.blacklistSASLMechanism("CRAM-MD5");
//        return con;
//    }
//}
