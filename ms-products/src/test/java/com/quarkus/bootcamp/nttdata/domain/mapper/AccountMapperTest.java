package com.quarkus.bootcamp.nttdata.domain.mapper;

import com.quarkus.bootcamp.nttdata.domain.entity.Account;
import com.quarkus.bootcamp.nttdata.infraestructure.entity.AccountD;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class AccountMapperTest {
  @Inject
  AccountMapper mapper;

  @Test
  public void toDtoNull() {
    Account account = null;
    Assertions.assertThrows(NullPointerException.class, () -> mapper.toDto(account));
  }

  @Test
  public void toEntityNull() {
    AccountD accountD = null;
    Assertions.assertThrows(NullPointerException.class, () -> mapper.toEntity(accountD));
  }

  @Test
  public void toDtoReturnDto() {
    Account account = new Account();
    AccountD actual = mapper.toDto(account);
    Assertions.assertInstanceOf(AccountD.class, actual);
  }

  @Test
  public void toEntityReturnEntity() {
    AccountD accountD = new AccountD();
    Account actual = mapper.toEntity(accountD);
    Assertions.assertInstanceOf(Account.class, actual);
  }

  @Test
  public void toDtoVoid() {
    Account account = new Account();
    AccountD expected = new AccountD();
    AccountD actual = mapper.toDto(account);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void toEntityVoid() {
    AccountD accountD = new AccountD();
    Account expected = new Account();
    Account actual = mapper.toEntity(accountD);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void toDtoValid() {
    // Variables
    Double amount = 500.00;
    Long customerId = 101L;
    Long cardId = 101L;

    // Input
    Account account = new Account();
    account.setAmount(amount);
    account.setCutomerId(customerId);
    account.setCardId(cardId);

    // Resultado esperado
    AccountD expected = new AccountD();
    expected.setAmount(amount);
    expected.setCutomerId(customerId);
    expected.setCardId(cardId);

    // Ejecución
    AccountD actual = mapper.toDto(account);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void toEntityValid() {
    // Variables
    Double amount = 500.00;
    Long customerId = 101L;
    Long cardId = 101L;

    // Input
    AccountD accountD = new AccountD();
    accountD.setAmount(amount);
    accountD.setCutomerId(customerId);
    accountD.setCardId(cardId);

    // Resultado esperado
    Account expected = new Account();
    expected.setAmount(amount);
    expected.setCutomerId(customerId);
    expected.setCardId(cardId);

    // Ejecución
    Account actual = mapper.toEntity(accountD);

    Assertions.assertEquals(expected, actual);
  }

}