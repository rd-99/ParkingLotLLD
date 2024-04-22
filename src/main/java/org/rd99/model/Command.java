package org.rd99.model;

import org.rd99.exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final String SPACE = " ";
    private String commandName;
    private List<String> params;

    Command(final String inputLine){
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(" "))
                                        .map(String::trim).filter(token -> (!token.isEmpty()))
                                        .collect(Collectors.toList());
        if(tokensList.isEmpty()){
            throw new InvalidCommandException();
        }
        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        params = tokensList;

    }

    public List<String> getParams() {
        return params;
    }

    public String getCommandName() {
        return commandName;
    }
}
