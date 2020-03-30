class Logger {

    Map<String, Integer> logger;
    /** Initialize your data structure here. */
    public Logger() {
        logger = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int oldTimestamp = logger.getOrDefault(message, -1);
        
        if(oldTimestamp < 0 || timestamp >= oldTimestamp + 10){
            logger.put(message, timestamp);
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */