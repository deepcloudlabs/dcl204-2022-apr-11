package com.example.banking.application;

import com.example.banking.domain.AccountStatus;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyEnum {

	public static void main(String[] args) {
		for (var accountStatus : AccountStatus.values()) {
			System.out.println(accountStatus.name() + ": " + accountStatus.getBddkCode());
		}

	}

}
