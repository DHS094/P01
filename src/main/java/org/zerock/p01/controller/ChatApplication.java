//package org.zerock.p01.controller;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import com.openai.OpenAI;
//
//@SpringBootApplication
//public class ChatApplication {
////    public static void main(String[] args) {
////        SpringApplication.run(ChatApplication.class, args);
////    }
//
//    @Controller
//    @RequestMapping("/chat")
//    public class ChatController {
//
//        // Spring Boot 컨트롤러를 생성합니다.
////        @GetMapping("/chat")
////        public String hello() {
////            return "chat_ui";
////        }
//
//        @PostMapping("/chat_ui_result")
//        @ResponseBody
//        public ChatResponse chatUIResult(@RequestParam("user_text") String userText) {
//            // userText를 사용하여 prompt를 생성합니다.
//            String prompt = userText;
//            System.out.println("prompt: " + prompt);
//
//            // OpenAI API 호출
//            OpenAI openAI = new OpenAI();
//            String response = openAI.getChatResponse(prompt);
//
//            // ChatResponse 객체를 생성하여 JSON으로 반환
//            ChatResponse chatResponse = new ChatResponse(response);
//            return chatResponse;
//        }
//    }
//}
//
//class OpenAI {
//    // OpenAI API 호출 및 응답을 반환하는 메서드
//    public String getChatResponse(String prompt) {
//        // OpenAI API 호출 로직을 여기에 구현하세요.
//        // 호출 및 응답 처리
//        return "This is a sample response from OpenAI";
//    }
//}
//
//class ChatResponse {
//    private String data;
//
//    public ChatResponse(String data) {
//        this.data = data;
//    }
//
//    public String getData() {
//        return data;
//    }
//}
