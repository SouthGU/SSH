��Ϊ�������ߣ�ÿ����������ʱ��Ӧ���ƶ�target�����ơ�ͬʱtarget������Ϊ�ұ�frame��name���ԡ�

```html
��һ���֣��ܹ�ҳ
<frameset cols="30%,*">
    <frame src="admin.jsp">
    <frame src="index.jsp" name="content">
</frameset>

�ڶ����֣�(admin.jsp���ѡ��)
<a  href="/action" target="content">
   ���Ͳ鿴       
</a>

�������֣�(index.jsp�ұ�ҳ�棬������ʱ�䷢��������ҳ��)
����������Ѿ��涨�˷��ص�ҳ��Ҫ��ʾ���ұ� target="content"���ұߵ�ҳ������ŷ���˴��ݻ�����JSPҳ�������
```

