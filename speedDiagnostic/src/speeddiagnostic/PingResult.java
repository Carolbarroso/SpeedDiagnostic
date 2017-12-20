/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speeddiagnostic;

/**
 *
 * @author natan
 */
public class PingResult {
    private final Integer ICMP_SEQ;
    private final Double TIME_MS;

    public PingResult(Integer icmp_seq, Double time_ms) {
        this.ICMP_SEQ = icmp_seq;
        this.TIME_MS = time_ms;
    }

    public Integer getICMP_SEQ() {
        return ICMP_SEQ;
    }

    public Double getTIME_MS() {
        return TIME_MS;
    }
    
}
