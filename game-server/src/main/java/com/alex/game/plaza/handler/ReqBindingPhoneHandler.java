package com.alex.game.plaza.handler;

import com.alex.game.message.CommonMessageProto.CommonMessage;
import com.alex.game.player.PlayerProto.ReqBindingPhone;
import com.alex.game.player.struct.Player;
import com.alex.game.plaza.PersonalCenterMgr;
import com.alex.game.server.tcp.Ihandler;
import com.google.inject.Inject;
import com.google.protobuf.InvalidProtocolBufferException;
/**
 * 绑定手机
 * @author yejuhua
 *
 */
public class ReqBindingPhoneHandler implements Ihandler {

	@Inject
	private PersonalCenterMgr personalCenterMgr;
	@Override
	public void action(Player player, CommonMessage msg) throws InvalidProtocolBufferException {
		ReqBindingPhone reqBindingPhone=ReqBindingPhone.parseFrom(msg.getContent());
		personalCenterMgr.bindingPhone(player,reqBindingPhone.getPhone(),reqBindingPhone.getCode());
	}

}
