package com.alex.game.games.gobang.handler;

import com.alex.game.games.gobang.manager.GobangMgr;
import com.alex.game.gobang.GobangProto.ReqEnterGobangRoom;
import com.alex.game.message.CommonMessageProto.CommonMessage;
import com.alex.game.player.struct.Player;
import com.alex.game.server.tcp.Ihandler;
import com.google.inject.Inject;
import com.google.protobuf.InvalidProtocolBufferException;

public class ReqEnterGobangRoomHandler implements Ihandler {

	@Inject
	private GobangMgr gobangMgr;
	@Override
	public void action(Player player, CommonMessage msg) throws InvalidProtocolBufferException {
		ReqEnterGobangRoom reqEnterGobangRoom=ReqEnterGobangRoom.parseFrom(msg.getContent());
		gobangMgr.enterRoom(player,reqEnterGobangRoom.getPwd());
	}

}
