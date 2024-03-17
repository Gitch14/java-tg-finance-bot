package com.bot.multimediadownloader.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {
    //@Value("${bot.name}")
    private final String botName = "MultiMediaDownloader_bot";
    //@Value("${bot.token}")
    private final String botKey = "6860409804:AAF5mxe2IQVUc2wPbN0XevzfyLtIPT-9Bqw";
}
