package com.rolandsall.twitter.to.kafka.service.external.runner;

import twitter4j.TwitterException;

public interface StreamRunner {

    void start() throws TwitterException;
}
