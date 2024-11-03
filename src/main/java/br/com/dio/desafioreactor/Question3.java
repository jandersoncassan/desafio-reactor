package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.Objects;

public class Question3 {

    /*
    Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
    (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres)
     */
    public Mono<Void> userIsValid(final User user){

        return Mono.just(user)
                .filter(userData -> isPasswordOk(userData.password()))
                .switchIfEmpty(Mono.defer(()-> Mono.error(new Exception(" Usuario invalido senha com menos de 8 caracteres"))))
                .flatMap(data -> Mono.empty());
    }

    private boolean isPasswordOk(final String password){
        return Objects.nonNull(password) && password.length() > 8;
    }

}

