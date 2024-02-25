package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в базу данных пользователей и инициализирует список его счетов.
     * Если пользователь уже существует в базе данных, новый список счетов не создается.
     *
     * @param user Пользователь, которого необходимо добавить.
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Удаляет пользователя из базы данных по его паспортным данным.
     * Если пользователь с указанным паспортным номером существует в базе данных,
     * то он будет удален, вместе со всеми его счетами.
     *
     * @param passport Паспортные данные пользователя, которого необходимо удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет для пользователя с указанными паспортными данными.
     * Если пользователь с указанными паспортными данными существует в базе данных,
     * то новый счет добавляется к списку его счетов, если он еще не существует.
     *
     * @param passport Паспортные данные пользователя, для которого необходимо добавить счет.
     * @param account  Счет, который необходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        User currentUser = findByPassport(passport);
        if (Objects.nonNull(currentUser)) {
            List<Account> accounts = getAccounts(currentUser);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя в базе данных по его паспортным данным.
     * Если пользователь с указанными паспортными данными найден в базе данных,
     * то возвращается объект пользователя, в противном случае возвращается null.
     *
     * @param passport Паспортные данные пользователя, которого необходимо найти.
     * @return Объект пользователя с указанными паспортными данными или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск счета по реквизитам для указанного пользователя.
     * Если пользователь с указанными паспортными данными существует в базе данных
     * и у него есть счет с указанными реквизитами, то возвращается объект этого счета.
     * В противном случае возвращается null.
     *
     * @param passport  Паспортные данные пользователя, для которого осуществляется поиск счета.
     * @param requisite Реквизиты счета, которые необходимо найти.
     * @return Объект счета с указанными реквизитами или null, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User currentUser = findByPassport(passport);
        if (!Objects.isNull(currentUser)) {
            List<Account> accounts = getAccounts(currentUser);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги со счета одного пользователя на счет другого пользователя.
     * Если у исходного счета достаточно средств для перевода и оба счета существуют,
     * то выполняется перевод указанной суммы и возвращается true. В противном случае
     * возвращается false.
     *
     * @param sourcePassport       Паспортные данные пользователя, у которого списываются средства.
     * @param sourceRequisite      Реквизиты счета, с которого списываются средства.
     * @param destinationPassport  Паспортные данные пользователя, которому зачисляются средства.
     * @param destinationRequisite Реквизиты счета, на который зачисляются средства.
     * @param amount               Сумма, которая переводится со счета отправителя на счет получателя.
     * @return true, если перевод выполнен успешно, иначе false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (Objects.nonNull(sourceAccount) && Objects.nonNull(destinationAccount)
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Получает список счетов для указанного пользователя.
     *
     * @param user Пользователь, для которого необходимо получить список счетов.
     * @return Список счетов указанного пользователя или null, если пользователь не найден.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}