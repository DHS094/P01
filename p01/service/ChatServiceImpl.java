package org.zerock.p01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.p01.repository.ChatRepository;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ChatServiceImpl implements ChatService {
    private final ModelMapper modelMapper;
    private final ChatRepository chatRepository;

//    @Override

}
