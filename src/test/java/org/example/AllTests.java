package org.example;

import org.example.habr.HabrTest;
import org.example.mail.MailTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({HabrTest.class, MailTest.class})
public class AllTests { }

