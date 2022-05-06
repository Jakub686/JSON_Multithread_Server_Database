package client;

import com.beust.jcommander.Parameter;

public class Args {

    @Parameter(names = {"-t"})
    String type;

    @Parameter(names = {"-k"})
    Integer key;

    @Parameter(names = {"-v"})
    String value;

}
