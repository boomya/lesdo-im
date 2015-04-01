package com.lesdo.im.packetExtension;

import org.jivesoftware.smack.packet.PacketExtension;

/**
 * Receipt extension.
 * 
 * http://xmpp.org/extensions/xep-0184.html
 * 
 * @author alexander.ivanov
 * 
 */
public class Received implements PacketExtension {

	public static final String ELEMENT_NAME = "received";
	public static final String NAMESPACE = "urn:xmpp:receipts";
	public static final String ID_ATTRIBUTE = " id";

	
	@Override
	public String getElementName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

	

	@Override
	public String toXML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<"+ELEMENT_NAME+"").append(ID_ATTRIBUTE + " =\"").append("P28rQ-14")
				.append("\">");
		sb.append("</"+ELEMENT_NAME+">");
//		sb.append("<"+ELEMENT_NAME+"").append(" xmlns=\"").append(NAMESPACE)
//		.append("\">").append("P28rQ-14");
//		sb.append("</"+ELEMENT_NAME+">");
		return sb.toString();
	}

}
