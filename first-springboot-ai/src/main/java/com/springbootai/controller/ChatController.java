package com.springbootai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }



   /* @GetMapping("/ask")
    public String askAI(@RequestParam String message) {
        return chatClient.prompt()
                .system("""
                    You are an expert Java instructor with 10+ years of teaching experience.
                    
                    RULES:
                    1. ONLY answer questions related to Java programming
                    2. If question is NOT related to Java, respond: 
                       "I can only help with Java programming questions. Please ask something about Java!"
                    3. Keep explanations simple and beginner-friendly
                    4. ALWAYS provide code examples when relevant
                    5. Explain concepts step by step
                    6. Use analogies to make complex topics easier to understand
                    7. Add comments in code examples for clarity
                    8. If code has errors, explain why and show the fix
                    
                    Example good responses format:
                    - Explanation: [simple explanation]
                    - Code Example: [working code]
                    - Key Points: [summary]
                    
                    Remember: You're teaching Java to a student, so be patient and encouraging!
                    """)
                .user(message)
                .call()
                .content();
    }*/


                /* Multiple Response Formats: */
    /*@GetMapping("/ask")
    public ResponseEntity<?> askAI(@RequestParam String message,
                                   @RequestParam(defaultValue = "simple") String format) {

        String systemPrompt = switch(format) {
            case "detailed" -> """
            Provide a comprehensive explanation including:
            - Theory behind the concept
            - Real-world analogy
            - Complete code example
            - Common mistakes to avoid
            - Best practices
            """;
            case "quick" -> """
            Provide a concise answer (2-3 sentences) with minimal code example
            """;
            default -> """
            Provide a balanced answer with:
            - Brief explanation
            - One code example
            - Key takeaway
            """;
        };

        String response = chatClient.prompt()
                .system(systemPrompt)
                .user(message)
                .call()
                .content();

        return ResponseEntity.ok(response);
    }*/

                        /* Multiple Topics Support: */
    @GetMapping("/ask")
    public ResponseEntity<?> askAI(@RequestParam String message,
                                   @RequestParam(defaultValue = "simple") String format) {

        String systemPrompt = switch(format) {
            case "detailed" -> """
            Provide a comprehensive explanation including:
            - Theory behind the concept
            - Real-world analogy
            - Complete code example
            - Common mistakes to avoid
            - Best practices
            """;
            case "quick" -> """
            Provide a concise answer (2-3 sentences) with minimal code example
            """;
            default -> """
            Provide a balanced answer with:
            - Brief explanation
            - One code example
            - Key takeaway
            """;
        };

        String response = chatClient.prompt()
                .system(systemPrompt)
                .user(message)
                .call()
                .content();

        return ResponseEntity.ok(response);
    }

}