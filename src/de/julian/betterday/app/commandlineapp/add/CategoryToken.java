package de.julian.betterday.app.commandlineapp.add;

class CategoryToken extends TokenType {
    @Override
    boolean fits(String token) {
        return true;
        //TODO use category manager?
    }
}
