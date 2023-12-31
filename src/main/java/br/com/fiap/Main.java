package br.com.fiap;


import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.ItemEstocado;
import br.com.fiap.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Deposito dep1 = new Deposito();
        dep1.setId( null ).setNome( "Vila Madalena" );

        Deposito dep2 = new Deposito();
        dep2.setId( null ).setNome( "Vila Mariana" );

        Produto p1 = new Produto();
        p1.setId( null )
                .setNome( "Abacaxi" )
                .setDescricao( "O mais delicia da feira" )
                .setValor( BigDecimal.valueOf( 4.99 ) );

        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "maria-db" );
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist( dep1 );
        manager.persist( dep2 );
        manager.persist( p1 );

        var cont = 0;
        var qtd = 50;

        while (cont < qtd) {
            var item = new ItemEstocado();
            var itemDep2 = new ItemEstocado();


            item.setDeposito( dep1 )
                    .setProduto( p1 )
                    .setEntrada( LocalDateTime.now() )
                    .setNumeroDeSerie( cont + "NR" + qtd + "-" + p1.getId() + "-" + dep1.getId() );


            itemDep2.setDeposito( dep2 )
                    .setProduto( p1 )
                    .setEntrada( LocalDateTime.now() )
                    .setNumeroDeSerie( cont + "NR" + qtd + "-" + p1.getId() + "-" + dep2.getId() );

            manager.persist( item );
            manager.persist( itemDep2 );
            cont++;
        }

        manager.getTransaction().commit();


        var jpql = "FROM ItemEstocado i join  fetch i.deposito  where i.deposito.id = 2L";

        List list = manager.createQuery( jpql ).getResultList();

        list.forEach( System.out::println );


        manager.close();
        factory.close();
    }
}