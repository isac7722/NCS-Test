package com.test.auth;

import com.test.dto.MemberDTO;

public interface SnsAuth {

    boolean login(MemberDTO memberDTO);
}
